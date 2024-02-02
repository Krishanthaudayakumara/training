import { Routes } from '@angular/router';
import { ComponentOneComponent } from './components/component-one/component-one.component';
import { ComponentTwoComponent } from './components/component-two/component-two.component';
import { RxjsTestComponent } from './components/rxjs-test/rxjs-test.component';
import { ComponentThreeComponent } from './components/component-three/component-three.component';
import { ComponentFourComponent } from './components/component-four/component-four.component';

export const routes: Routes = [
    {path: 'one', component: ComponentOneComponent},
    {path: 'two', component: ComponentTwoComponent},
    {path: 'three', component: ComponentThreeComponent},
    {path: 'four', component: ComponentFourComponent},
    {path: 'rxjs', component: RxjsTestComponent},
];
