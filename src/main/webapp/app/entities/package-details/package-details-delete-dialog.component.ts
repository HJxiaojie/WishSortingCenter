import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IPackageDetails } from 'app/shared/model/package-details.model';
import { PackageDetailsService } from './package-details.service';

@Component({
  templateUrl: './package-details-delete-dialog.component.html',
})
export class PackageDetailsDeleteDialogComponent {
  packageDetails?: IPackageDetails;

  constructor(
    protected packageDetailsService: PackageDetailsService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.packageDetailsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('packageDetailsListModification');
      this.activeModal.close();
    });
  }
}
