import { Component } from '@angular/core';
import {Server} from '../../../../model/server';
import {CardServerManagerComponent} from '../../../cards/card-server-manager/card-server-manager.component';

@Component({
  standalone: true,
  imports: [
    CardServerManagerComponent
  ],
  templateUrl: './minecraft.component.html',
  styleUrl: './minecraft.component.scss'
})
export class MinecraftComponent {

  server: Server = {
    id: "minecraft",
    name: "Minecraft"
  };

}
