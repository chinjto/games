import { Component } from '@angular/core';
import {MatToolbar} from '@angular/material/toolbar';
import {MatIcon} from '@angular/material/icon';
import {MatButton, MatIconButton} from '@angular/material/button';

@Component({
  selector: 'section-header',
  standalone: true,
  templateUrl: './header.component.html',
  imports: [
    MatToolbar,
    MatIcon,
    MatIconButton,
    MatButton
  ],
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

}
