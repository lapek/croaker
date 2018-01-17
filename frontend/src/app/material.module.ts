import {
  MatButtonModule, MatCardModule, MatGridListModule, MatIconModule, MatInputModule, MatProgressBarModule,
  MatProgressSpinnerModule,
  MatSnackBarModule, MatToolbarModule
} from '@angular/material';
import {NgModule} from '@angular/core';

@NgModule({
  imports: [
    MatToolbarModule,
    MatInputModule,
    MatButtonModule,
    MatProgressSpinnerModule,
    MatCardModule,
    MatGridListModule,
    MatIconModule,
    MatSnackBarModule,
    MatProgressBarModule
  ],
  exports: [
    MatToolbarModule,
    MatInputModule,
    MatButtonModule,
    MatProgressSpinnerModule,
    MatCardModule,
    MatGridListModule,
    MatIconModule,
    MatSnackBarModule,
    MatProgressBarModule
  ],
})

export class MaterialModule {
}
