

import Home from './Home'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import ExtraUserDetails from './ExtraUserDetails'
import ProfilesView from './ProfilesView'



function App() {
  

  return (
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path='/profile' element={<ProfilesView />}/>
      </Routes>
  )
}

export default App
