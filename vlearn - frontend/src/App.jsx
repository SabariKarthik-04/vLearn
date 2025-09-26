

import Home from './Home'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import ExtraUserDetails from './ExtraUserDetails'



function App() {
  

  return (
      <Routes>
        <Route path="/" element={<Home />}/>
      </Routes>
  )
}

export default App
