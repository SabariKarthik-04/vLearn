import React, { createContext, useState } from "react";

// Step 1: Create the context
export const LoginRegisterContext = createContext();

// Step 2: Create the provider component
const LoginRegisterProvider = ({ children }) => {
  const [user, setUser] = useState(null);

  return (
    <LoginRegisterContext.Provider value={{ user, setUser }}>
      {children}
    </LoginRegisterContext.Provider>
  );
};

export default LoginRegisterProvider;
