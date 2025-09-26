import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Login from './Login.jsx'
import Register from './Register.jsx'
import { VlearnProvider } from './context/VlearnProvider.jsx'
import ExtraUserDetails from './ExtraUserDetails.jsx'
import LoginRegisterProvider from './context/LoginRegisterProvider.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/login' element={
          <LoginRegisterProvider>
          <Login />
          </LoginRegisterProvider>
        } />
        <Route path='/register' element={
          <LoginRegisterProvider>
          <Register />
          </LoginRegisterProvider>
          } 
          />  
        <Route path='/adv-register' element={
          <LoginRegisterProvider>
          <ExtraUserDetails />
          </LoginRegisterProvider>
          } />
        <Route path='/*' element={
          <VlearnProvider>
            <App />
          </VlearnProvider>
          } />  
      </Routes>  
    </BrowserRouter>
  </StrictMode>,
)
