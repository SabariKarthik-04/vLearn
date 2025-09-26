import { Navigate } from "react-router-dom";
import {jwtDecode} from "jwt-decode";

const isAuthenticated = () => {
  const token = localStorage.getItem("token");
  if (!token) return false;

  try {
    const { exp } = jwtDecode(token);
    return Date.now() < exp * 1000;
  } catch (err) {
    return false;
  }
};

export default function PrivateRoute({ children }) {
  return isAuthenticated() ? children : <Navigate to="/login" />;
}
