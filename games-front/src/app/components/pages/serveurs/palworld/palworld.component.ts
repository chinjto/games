import { Component } from '@angular/core';
import {CardServerManagerComponent} from '../../../cards/card-server-manager/card-server-manager.component';
import {Server} from '../../../../model/server';

@Component({
  standalone: true,
  imports: [
    CardServerManagerComponent
  ],
  templateUrl: './palworld.component.html',
  styleUrl: './palworld.component.scss'
})
export class PalworldComponent {

  server: Server = {
    id: "palworld",
    name: "Palworld"
  };

}
