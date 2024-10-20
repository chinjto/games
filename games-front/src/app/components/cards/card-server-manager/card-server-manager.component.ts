import {Component, inject, input, InputSignal} from '@angular/core';
import {MatCard, MatCardContent, MatCardHeader, MatCardSubtitle, MatCardTitle} from '@angular/material/card';
import {MatIcon} from '@angular/material/icon';
import {Server} from '../../../model/server';
import {ServerService} from '../../../core/services/server.service';

@Component({
  selector: 'card-server-manager',
  standalone: true,
  imports: [
    MatCard,
    MatCardHeader,
    MatCardTitle,
    MatCardContent,
    MatIcon,
    MatCardSubtitle,
  ],
  templateUrl: './card-server-manager.component.html',
  styleUrl: './card-server-manager.component.scss'
})
export class CardServerManagerComponent {

  public isOn: boolean = false;

  public server: InputSignal<Server> = input.required<Server>();
  public updatable: InputSignal<boolean> = input.required<boolean>();

  private serverService: ServerService = inject(ServerService);

  start() {
    this.serverService.start(this.server().id).subscribe();
  }

  restart() {
    this.serverService.restart(this.server().id).subscribe();
  }

  stop() {
    this.serverService.stop(this.server().id).subscribe();
  }

  update() {
    if (this.updatable()) {
      this.serverService.update(this.server().id).subscribe();
    }
  }

}
