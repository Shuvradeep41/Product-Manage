import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { CartComponent } from './components/cart/cart.component';
import { LoginComponent } from './components/login/login.component';
import { ProductsComponent } from './components/products/products.component';
import { SignupComponent } from './components/signup/signup.component';
import { WishlistComponent } from './components/wishlist/wishlist.component';
import { SearchComponent } from './components/search/search.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: 'products',
    component: ProductsComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'cart',
    component: CartComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'wishlist',
    component: WishlistComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'search/:searchTerm',
    component: SearchComponent,
    canActivate: [AuthGuard],
  },
  { path: '**', redirectTo: 'login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

export const routingComponents = [
  LoginComponent,
  ProductsComponent,
  SignupComponent,
  CartComponent,
  WishlistComponent,
];
