import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IPackageDetails } from 'app/shared/model/package-details.model';

type EntityResponseType = HttpResponse<IPackageDetails>;
type EntityArrayResponseType = HttpResponse<IPackageDetails[]>;

@Injectable({ providedIn: 'root' })
export class PackageDetailsService {
  public resourceUrl = SERVER_API_URL + 'api/package-details';

  constructor(protected http: HttpClient) {}

  create(packageDetails: IPackageDetails): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(packageDetails);
    return this.http
      .post<IPackageDetails>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(packageDetails: IPackageDetails): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(packageDetails);
    return this.http
      .put<IPackageDetails>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IPackageDetails>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IPackageDetails[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(packageDetails: IPackageDetails): IPackageDetails {
    const copy: IPackageDetails = Object.assign({}, packageDetails, {
      finishTime: packageDetails.finishTime && packageDetails.finishTime.isValid() ? packageDetails.finishTime.toJSON() : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.finishTime = res.body.finishTime ? moment(res.body.finishTime) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((packageDetails: IPackageDetails) => {
        packageDetails.finishTime = packageDetails.finishTime ? moment(packageDetails.finishTime) : undefined;
      });
    }
    return res;
  }
}
