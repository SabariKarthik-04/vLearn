import React, { createContext, useEffect, useState } from 'react'
import { jwtDecode } from "jwt-decode";
import { useNavigate } from 'react-router-dom';

export const VlearnContext = createContext();

export const VlearnProvider = ({children}) => {
  const nav = useNavigate();
  const [userData,setUserData] = useState();
  const token = localStorage.getItem("token")

  function logout() {
    try {
      localStorage.removeItem("token");
    } catch (error) {
      console.log(error);
    }
  }

  async function fetchData(userId,token) {
    try {
      const response = await fetch(`http://localhost:8080/auth/fetch-data/${userId}`,
        {headers:{
          "authorization":`Bearer ${token}`
        }}
      );
      if(response.status==200){
        const data = await response.json();
        setUserData(data.user);
      }else{
        logout();
      }
      
    } catch (error) {
      throw error;
    }
  }
  // useEffect(()=>{
  //   if(token!=null){
  //     const {sub } = jwtDecode(token);
  //     fetchData(sub,token);
  //   }else{
  //     nav('/login')
  //   }
  // },[])

  return (
    <VlearnContext.Provider value={{fetchData,userData}}>
      {children}
    </VlearnContext.Provider>
  )
}


