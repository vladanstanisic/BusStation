import { combineReducers } from "redux";
import getCompaniesReducers from "./GetCompaniesReducers";

export default combineReducers ({
    companies: getCompaniesReducers
});