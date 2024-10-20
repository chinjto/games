import { Routes } from '@angular/router';
import {AccueilComponent} from './components/pages/accueil/accueil.component';
import {PalworldComponent} from './components/pages/serveurs/palworld/palworld.component';
import {FuturComponent} from './components/pages/futur/futur.component';
import {MinecraftComponent} from './components/pages/serveurs/minecraft/minecraft.component';
import {AllComponent} from './components/pages/serveurs/all/all.component';

export const routes: Routes = [
  {
    path: '',
    component: AccueilComponent,
    data: { title: 'Dashboard' },
  },
  {
    path: 'futur',
    component: FuturComponent,
    data: { title: 'Jeux à venir' },
  },
  {
    path: 'serveurs',
    children: [
      {
        path: 'all',
        component: AllComponent,
        data: { title: 'Serveurs' },
      },
      {
        path: 'minecraft',
        component: MinecraftComponent,
        data: { title: 'Minecraft' },
      },
      {
        path: 'palworld',
        component: PalworldComponent,
        data: { title: 'Palworld' },
      },
    ],
  }
];
