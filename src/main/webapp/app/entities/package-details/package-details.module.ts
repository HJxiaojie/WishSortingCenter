import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WishSortingCenterSharedModule } from 'app/shared/shared.module';
import { PackageDetailsComponent } from './package-details.component';
import { PackageDetailsDetailComponent } from './package-details-detail.component';
import { PackageDetailsUpdateComponent } from './package-details-update.component';
import { PackageDetailsDeleteDialogComponent } from './package-details-delete-dialog.component';
import { packageDetailsRoute } from './package-details.route';

@NgModule({
  imports: [WishSortingCenterSharedModule, RouterModule.forChild(packageDetailsRoute)],
  declarations: [
    PackageDetailsComponent,
    PackageDetailsDetailComponent,
    PackageDetailsUpdateComponent,
    PackageDetailsDeleteDialogComponent,
  ],
  entryComponents: [PackageDetailsDeleteDialogComponent],
})
export class WishSortingCenterPackageDetailsModule {}
