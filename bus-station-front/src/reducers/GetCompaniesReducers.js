const getCompaniesReducers = function (companies = [], action) {
    switch(action.type) {
        case "GET_COMPANIES":
            return action.payload;
        default:
            return companies;
    }
};

export default getCompaniesReducers;