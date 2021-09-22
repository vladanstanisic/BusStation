import React from 'react';
import Axios from '../../apis/Axios';
import {Button, Form} from 'react-bootstrap'

class Reservation extends React.Component {

    constructor(props) {
        super(props);

        this.state = { lineId: -1, numberOfSeats: 0 }
    }

    componentDidMount() {
        this.getLineById(this.props.match.params.id);
     }

     getLineById(lineId) {
        Axios.get('/lines/' + lineId)
        .then(res => {
            // handle success
            this.setState({lineId: res.data.id});
            console.log('Id of line is ' + this.state.lineId)
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Unable to get line!');
         });
    }

    onNumberOfSeatsChange = event => {
        console.log(event.target.value);
        let input = event.target;
        let value = input.value;

        this.setState({
            numberOfSeats: value
          },function(){
            console.log('Number of seats ' + this.state.numberOfSeats)
            console.log('Line id ' + this.state.lineId)
          })
    }

    reservation(event) {
        event.preventDefault();
        let config = {
            params: {
                id: this.state.lineId,
                numberOfSeats: this.state.numberOfSeats
            }
        }
        
        Axios.get('/reservations', config)
        .then(res => {
            // handle success
            console.log(res);
            alert('Successful reservation! Enjoy your travel!');
            this.props.history.push('/lines');
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Reservation is unsuccessful!');
         });
    }

    render () {
        return (
            <div>
                <h1>Reservation</h1>
                <Form>
                <Form.Label htmlFor="numberOfSeats">Broj mesta</Form.Label><br/>
                <Form.Control id="numberOfSeats" type="number" value={this.state.numberOfSeats} onChange={(event) => this.onNumberOfSeatsChange(event)}/><br/>

                <Button className="btn btn-primary" onClick={(event) => this.reservation(event)}>Reserve</Button>
                </Form>
            </div>
        )
    }
}

export default Reservation;