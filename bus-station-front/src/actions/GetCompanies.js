import { getCompanies } from './../apis/Axios';


let getCompaniesAction = function () {

    return async function (dispatch, getState ) {
        try{
            let companies = await getCompanies();
            dispatch({ type: "GET_COMPANIES", payload: companies})
        }catch(error){
            dispatch({ type: "GET_COMPANIES", payload: [] });
        }
    }
}

export default getCompaniesAction;