import { Component } from '@angular/core';
import {MatListItem, MatNavList} from '@angular/material/list';
import {MatDivider} from '@angular/material/divider';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'section-menu',
  standalone: true,
  imports: [
    MatNavList,
    MatListItem,
    MatDivider,
    RouterLink
  ],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent {

}
