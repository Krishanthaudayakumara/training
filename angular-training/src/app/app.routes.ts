import { Routes } from '@angular/router';
import { ComponentOneComponent } from './components/component-one/component-one.component';
import { ComponentTwoComponent } from './components/component-two/component-two.component';
import { RxjsTestComponent } from './components/rxjs-test/rxjs-test.component';

export const routes: Routes = [
    {path: 'one', component: ComponentOneComponent},
    {path: 'two', component: ComponentTwoComponent},
    {path: 'rxjs', component: RxjsTestComponent},
];
