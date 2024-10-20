import {Component, inject, OnInit} from '@angular/core';
import {RouterModule, ActivatedRoute, RouterOutlet} from '@angular/router';
import {HeaderComponent} from './components/sections/header/header.component';
import {MenuComponent} from './components/sections/menu/menu.component';
import {FooterComponent} from './components/sections/footer/footer.component';
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from '@angular/material/sidenav';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, RouterOutlet, HeaderComponent, MenuComponent, FooterComponent, MatSidenav, MatSidenavContainer, MatSidenavContent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {

  title: string = 'games-front';
  page: string = 'Undefined title';

  route = inject(ActivatedRoute);

  ngOnInit() {
    // FIXME
    // console.debug("1", this.route.snapshot.data);
    this.route.data.subscribe(data => {
      // console.debug("2", data);
      if (data['title']) {
        this.page = data['title'];
      }
    });
  }

}
