import Login from './pages/login.svelte';
import Signup from './pages/signup.svelte';
import ForgotPassword from './pages/ForgotPassword.svelte';
import ResetPassword from './pages/ResetPassword.svelte';
import StudentDashboard from './pages/StudentDashboard.svelte';
import UploadProject from './pages/UploadProject.svelte'; 
import Logout from './pages/Logout.svelte';
import Projects from './pages/Projects.svelte';
import ProjectDetails from './pages/ProjectDetails.svelte';
import CreateProject from './pages/chair/CreateProject.svelte';
import CreateEdition from './pages/chair/CreateEdition.svelte';
import ConstantProject from './pages/student/ConstantProject.svelte';
import DynamicProject from './pages/student/DynamicProject.svelte';
import ViewProject from './pages/student/ViewProject.svelte';
import Evaluations from './pages/supervisor/Evaluations.svelte';
import EvaluationPage from './pages/supervisor/EvaluationPage.svelte';



export const routes = {
  '/': Login,
  '/signup': Signup,
  '/forgot-password': ForgotPassword,
  '/reset-password': ResetPassword,
  '/dashboard': StudentDashboard,
  '/projects': Projects,
  '/upload-project': UploadProject,  
  '/logout': Logout,
  '/projects/:id': ProjectDetails,
  '/create-project': CreateProject,     
  '/create-edition': CreateEdition,    
  '/my-projects/constant': ConstantProject,
  '/my-projects/dynamic': DynamicProject,
  '/my-projects/view': ViewProject, 
  '/evaluations': Evaluations,
  '/evaluations/:id': EvaluationPage,
  
};
