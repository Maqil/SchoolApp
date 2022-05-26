import React, { useEffect, useState } from "react";
import { Outlet, Navigate } from "react-router-dom";
import { useAuth } from "../../providers/Auth";
import Loader from "../Loader/Loader";

const PrivateRoute = () => {
  const user = useAuth();
  const [state, setState] = useState({});
  useEffect(() => {
    const fetchState = async () => {
      // await user.checkSessionExpired();
      setState(JSON.parse(sessionStorage.getItem("alertMessage") || "{}"));
    };
    fetchState();
  }, [user]);

  if (user.loading) return <Loader />;
  return user.user ? <Outlet /> : <Navigate to="/login" state={state} />;
};

export default PrivateRoute;
