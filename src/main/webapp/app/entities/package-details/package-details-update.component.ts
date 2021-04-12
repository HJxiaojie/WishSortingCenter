import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IPackageDetails, PackageDetails } from 'app/shared/model/package-details.model';
import { PackageDetailsService } from './package-details.service';

@Component({
  selector: 'jhi-package-details-update',
  templateUrl: './package-details-update.component.html',
})
export class PackageDetailsUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    trackingId: [],
    groupId: [],
    jobId: [],
    isFinish: [],
    finishTime: [],
    userCode: [],
    xNum: [],
    yNum: [],
    xy: [],
  });

  constructor(protected packageDetailsService: PackageDetailsService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ packageDetails }) => {
      if (!packageDetails.id) {
        const today = moment().startOf('day');
        packageDetails.finishTime = today;
      }

      this.updateForm(packageDetails);
    });
  }

  updateForm(packageDetails: IPackageDetails): void {
    this.editForm.patchValue({
      id: packageDetails.id,
      trackingId: packageDetails.trackingId,
      groupId: packageDetails.groupId,
      jobId: packageDetails.jobId,
      isFinish: packageDetails.isFinish,
      finishTime: packageDetails.finishTime ? packageDetails.finishTime.format(DATE_TIME_FORMAT) : null,
      userCode: packageDetails.userCode,
      xNum: packageDetails.xNum,
      yNum: packageDetails.yNum,
      xy: packageDetails.xy,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const packageDetails = this.createFromForm();
    if (packageDetails.id !== undefined) {
      this.subscribeToSaveResponse(this.packageDetailsService.update(packageDetails));
    } else {
      this.subscribeToSaveResponse(this.packageDetailsService.create(packageDetails));
    }
  }

  private createFromForm(): IPackageDetails {
    return {
      ...new PackageDetails(),
      id: this.editForm.get(['id'])!.value,
      trackingId: this.editForm.get(['trackingId'])!.value,
      groupId: this.editForm.get(['groupId'])!.value,
      jobId: this.editForm.get(['jobId'])!.value,
      isFinish: this.editForm.get(['isFinish'])!.value,
      finishTime: this.editForm.get(['finishTime'])!.value ? moment(this.editForm.get(['finishTime'])!.value, DATE_TIME_FORMAT) : undefined,
      userCode: this.editForm.get(['userCode'])!.value,
      xNum: this.editForm.get(['xNum'])!.value,
      yNum: this.editForm.get(['yNum'])!.value,
      xy: this.editForm.get(['xy'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPackageDetails>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
