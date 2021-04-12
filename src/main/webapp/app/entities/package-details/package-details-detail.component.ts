import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IPackageDetails } from 'app/shared/model/package-details.model';

@Component({
  selector: 'jhi-package-details-detail',
  templateUrl: './package-details-detail.component.html',
})
export class PackageDetailsDetailComponent implements OnInit {
  packageDetails: IPackageDetails | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ packageDetails }) => (this.packageDetails = packageDetails));
  }

  previousState(): void {
    window.history.back();
  }
}
