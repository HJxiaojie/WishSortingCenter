import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IJob, Job } from 'app/shared/model/job.model';
import { JobService } from './job.service';

@Component({
  selector: 'jhi-job-update',
  templateUrl: './job-update.component.html',
})
export class JobUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    version: [],
    jobId: [],
    isCurrent: [],
    startTime: [],
    finishTime: [],
    totalGroups: [],
    totalParcels: [],
    xNum: [],
    yNum: [],
  });

  constructor(protected jobService: JobService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ job }) => {
      if (!job.id) {
        const today = moment().startOf('day');
        job.startTime = today;
        job.finishTime = today;
      }

      this.updateForm(job);
    });
  }

  updateForm(job: IJob): void {
    this.editForm.patchValue({
      id: job.id,
      version: job.version,
      jobId: job.jobId,
      isCurrent: job.isCurrent,
      startTime: job.startTime ? job.startTime.format(DATE_TIME_FORMAT) : null,
      finishTime: job.finishTime ? job.finishTime.format(DATE_TIME_FORMAT) : null,
      totalGroups: job.totalGroups,
      totalParcels: job.totalParcels,
      xNum: job.xNum,
      yNum: job.yNum,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const job = this.createFromForm();
    if (job.id !== undefined) {
      this.subscribeToSaveResponse(this.jobService.update(job));
    } else {
      this.subscribeToSaveResponse(this.jobService.create(job));
    }
  }

  private createFromForm(): IJob {
    return {
      ...new Job(),
      id: this.editForm.get(['id'])!.value,
      version: this.editForm.get(['version'])!.value,
      jobId: this.editForm.get(['jobId'])!.value,
      isCurrent: this.editForm.get(['isCurrent'])!.value,
      startTime: this.editForm.get(['startTime'])!.value ? moment(this.editForm.get(['startTime'])!.value, DATE_TIME_FORMAT) : undefined,
      finishTime: this.editForm.get(['finishTime'])!.value ? moment(this.editForm.get(['finishTime'])!.value, DATE_TIME_FORMAT) : undefined,
      totalGroups: this.editForm.get(['totalGroups'])!.value,
      totalParcels: this.editForm.get(['totalParcels'])!.value,
      xNum: this.editForm.get(['xNum'])!.value,
      yNum: this.editForm.get(['yNum'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IJob>>): void {
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
