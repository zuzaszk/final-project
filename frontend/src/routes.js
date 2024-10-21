import Login from './pages/login.svelte';
import Signup from './pages/signup.svelte';
import ForgotPassword from './pages/ForgotPassword.svelte';
import ResetPassword from './pages/ResetPassword.svelte';
import UsosCallback from './pages/UsosCallback.svelte';
import GoogleCallback from './pages/GoogleCallback.svelte';
import FacebookCallback from './pages/FacebookCallback.svelte';
import StudentDashboard from './pages/StudentDashboard.svelte';

export const routes = {
  '/': Login,
  '/signup': Signup,
  '/forgot-password': ForgotPassword,
  '/reset-password': ResetPassword,  
  '/usos-callback': UsosCallback,
  '/google-callback': GoogleCallback,
  '/facebook-callback': FacebookCallback,
  '/dashboard': StudentDashboard, 
};
