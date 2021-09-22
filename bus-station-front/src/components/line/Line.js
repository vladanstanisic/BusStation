  
import React from 'react';
import {Table, Button, Form} from 'react-bootstrap'
import Axios from '../../apis/Axios';
import getCompaniesAction from "../../actions/GetCompanies";
import { connect } from "react-redux";

class Line extends React.Component {

    constructor(props){
        super(props);

        this.state = { 
            lines: [],
            companies:[],
            search: {destination:"", companyId: null, maximumPrice: 0.00},
            pageNo: 0, 
            totalPages: 0
        };
    }

    componentDidMount (){
        this.getLines(0);
        this.props.getCompanies();
    }

    getCompanies() {
        Axios.get('/companies')
            .then(res => {
                 // handle success
                 console.log(res);
                 this.setState({companies: res.data});
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Unable to get companies!');
            });
    }

    getLines(pageNo) {
        let config = {
            params: {
                pageNo: pageNo
            },
          }

        if (this.state.search.destination != "") {
            config.params.destination = this.state.search.destination;
        }  
        if (this.state.search.companyId != null) {
            config.params.companyId = this.state.search.companyId;
        }  
        if (this.state.search.maximumPrice != 0.00) {
            config.params.maximumPrice = this.state.search.maximumPrice;
        }  

        Axios.get('/lines', config)
            .then(res => {
                 // handle success
                 console.log(res);
                 this.setState({
                    lines: res.data,
                    totalPages:res.headers["total-pages"]});
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Unable to get lines!');
            });
    }

    searchValueChange(event) {
        let control = event.target;

        let name = control.name
        let value = control.value

        let search = this.state.search

        search[name] = value

        this.setState({search:search})
        console.log(this.state.search)
    }

    delete(taskId) {
        Axios.delete('/lines/' + taskId)
        .then(res => {
            console.log(res);
            alert("Line is deleted!")
            window.location.reload()
        })
        .catch(error => {
            console.log(error);
            alert("Line is not deleted!")
        })
    }

    renderLines() {
        return this.state.lines.map ((line) => {
            return (
                <tr key={line.id}>
                    <td>{line.availableSeats}</td>
                    <td>{line.price}</td>
                    <td>{line.scheduled}</td>
                    <td>{line.destination}</td>
                    <td>{line.companyDTO.name}</td>
                    <td><button className="btn btn-primary" onClick={() => this.edit(line.id)}>Edit</button></td>
                    <td><button className="btn btn-danger" onClick={() => this.delete(line.id)}>Delete</button></td>
                    <td><button className="btn btn-success" onClick={() => this.reservation(line.id)}>Reserve</button></td>
                </tr>
            )
        })
    }

    reservation(lineId) {
        this.props.history.push('/lines/reservation/'+ lineId);
    }

    edit(lineId) {
        this.props.history.push('/lines/edit/'+ lineId);
    }

    search() {
        this.getLines();
    }

    addLine() {
        this.props.history.push('/lines/add')
    } 

    render() {
        return (
            <div>
                <h1>Lines</h1>
                <Button className="btn btn-primary" type="submit" onClick = {() => this.addLine()}>Add line</Button><br/>
                <Form>
                    <Form.Label htmlFor="lDestination">Destination</Form.Label><br/>
                    <Form.Control id="lDestination" name="destination" type="text" value={this.state.search.destination} onChange={(e) => this.searchValueChange(e)}/><br/>
                    <Form.Label htmlFor="lcompanyId">Company</Form.Label><br/>
                    <Form.Control as="select" id="lcompanyId" name="companyId" onChange={(e) => this.searchValueChange(e)}>
                    <option></option>
                    {
                        this.props.companies.map((company) => {
                            return (
                                <option key={company.id} value={company.id}>
                                    {company.name}
                                </option>
                            )
                        })
                    }
                    </Form.Control><br/>
                    <Form.Label htmlFor="lmaximumPrice">Maximum price</Form.Label><br/>
                    <Form.Control id="lmaximumPrice" name="maximumPrice" type="number" onChange={(e) => this.searchValueChange(e)}/><br/>

                    <Button style={{ marginTop: "1px" }} className="button btn-primary" onClick={()=>{this.search();}}>Search</Button>
                </Form>
                <div>
                <Table style={{marginTop:30}} className="table table-dark">
                        <thead>
                            <tr>
                                <th>Available seats</th>
                                <th>Price</th>
                                <th>Scheduled</th>
                                <th>Destination</th>
                                <th>Company</th>
                                <th>Actions</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderLines()}
                        </tbody>
                </Table>
                    <div>
                        <Button disabled={this.state.pageNo==0} className="btn btn-primary" onClick={() =>this.getLines(this.state.pageNo = this.state.pageNo - 1)}>Previous</Button>
                        <Button disabled={this.state.pageNo==this.state.totalPages-1} className="btn btn-primary" onClick={() =>this.getLines(this.state.pageNo = this.state.pageNo + 1)}>Next</Button>
                    </div>
                </div>    
            </div>
        )
    }
}

const mapStateToProps = (state, ownProps) => {
    // console.log(state);
    return { companies: state.companies };
  };
  
  export default connect(mapStateToProps, {
    getCompanies: getCompaniesAction,
  })(Line);