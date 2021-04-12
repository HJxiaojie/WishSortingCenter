import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IPackageDetails } from 'app/shared/model/package-details.model';
import { PackageDetailsService } from './package-details.service';
import { PackageDetailsDeleteDialogComponent } from './package-details-delete-dialog.component';

@Component({
  selector: 'jhi-package-details',
  templateUrl: './package-details.component.html',
})
export class PackageDetailsComponent implements OnInit, OnDestroy {
  packageDetails?: IPackageDetails[];
  eventSubscriber?: Subscription;

  constructor(
    protected packageDetailsService: PackageDetailsService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.packageDetailsService.query().subscribe((res: HttpResponse<IPackageDetails[]>) => (this.packageDetails = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInPackageDetails();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IPackageDetails): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInPackageDetails(): void {
    this.eventSubscriber = this.eventManager.subscribe('packageDetailsListModification', () => this.loadAll());
  }

  delete(packageDetails: IPackageDetails): void {
    const modalRef = this.modalService.open(PackageDetailsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.packageDetails = packageDetails;
  }
}
