import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { WishSortingCenterSharedModule } from 'app/shared/shared.module';
import { WishSortingCenterCoreModule } from 'app/core/core.module';
import { WishSortingCenterAppRoutingModule } from './app-routing.module';
import { WishSortingCenterHomeModule } from './home/home.module';
import { WishSortingCenterEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    WishSortingCenterSharedModule,
    WishSortingCenterCoreModule,
    WishSortingCenterHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    WishSortingCenterEntityModule,
    WishSortingCenterAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class WishSortingCenterAppModule {}
