import { Route } from "react-router";


import { BrowserRouter, Routes } from "react-router-dom";
import Home from "./Home";
import Order from "./Orders";

function RoutesSite() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/orders" element={<Order/>}/>
            </Routes>
        </BrowserRouter>
    )
}

export default RoutesSite