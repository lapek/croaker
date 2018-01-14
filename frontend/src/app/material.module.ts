import {MatButtonModule, MatInputModule, MatToolbarModule} from '@angular/material';
import {NgModule} from '@angular/core';

@NgModule({
  imports: [
    MatToolbarModule,
    MatInputModule,
    MatButtonModule
  ],
  exports: [
    MatToolbarModule,
    MatInputModule,
    MatButtonModule
  ],
})

export class MaterialModule {
}
