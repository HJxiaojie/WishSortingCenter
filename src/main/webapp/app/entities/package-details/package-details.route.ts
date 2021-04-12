import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IPackageDetails, PackageDetails } from 'app/shared/model/package-details.model';
import { PackageDetailsService } from './package-details.service';
import { PackageDetailsComponent } from './package-details.component';
import { PackageDetailsDetailComponent } from './package-details-detail.component';
import { PackageDetailsUpdateComponent } from './package-details-update.component';

@Injectable({ providedIn: 'root' })
export class PackageDetailsResolve implements Resolve<IPackageDetails> {
  constructor(private service: PackageDetailsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IPackageDetails> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((packageDetails: HttpResponse<PackageDetails>) => {
          if (packageDetails.body) {
            return of(packageDetails.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new PackageDetails());
  }
}

export const packageDetailsRoute: Routes = [
  {
    path: '',
    component: PackageDetailsComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'PackageDetails',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: PackageDetailsDetailComponent,
    resolve: {
      packageDetails: PackageDetailsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'PackageDetails',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: PackageDetailsUpdateComponent,
    resolve: {
      packageDetails: PackageDetailsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'PackageDetails',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: PackageDetailsUpdateComponent,
    resolve: {
      packageDetails: PackageDetailsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'PackageDetails',
    },
    canActivate: [UserRouteAccessService],
  },
];
