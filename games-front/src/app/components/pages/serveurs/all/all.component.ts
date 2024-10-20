import { Component } from '@angular/core';
import {Server} from '../../../../model/server';
import {CardServerManagerComponent} from '../../../cards/card-server-manager/card-server-manager.component';

@Component({
  standalone: true,
  imports: [
    CardServerManagerComponent
  ],
  templateUrl: './all.component.html',
  styleUrl: './all.component.scss'
})
export class AllComponent {

  minecraft: Server = {
    id: "minecraft",
    name: "Minecraft"
  };

  palworld: Server = {
    id: "palworld",
    name: "Palworld"
  };

}
