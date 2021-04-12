import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'job',
        loadChildren: () => import('./job/job.module').then(m => m.WishSortingCenterJobModule),
      },
      {
        path: 'package-details',
        loadChildren: () => import('./package-details/package-details.module').then(m => m.WishSortingCenterPackageDetailsModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class WishSortingCenterEntityModule {}
