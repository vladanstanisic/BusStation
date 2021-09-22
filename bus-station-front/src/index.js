import React from 'react';
import ReactDOM from 'react-dom';
import { Route, Link, HashRouter as Router, Switch } from 'react-router-dom';
import { Navbar, Container } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './components/Home';


class App extends React.Component{
    render() {
        return (
            <div>
                <Router>
                    <Navbar expand bg="dark" variant="dark">
                        <Navbar.Brand as={Link} to="/">
                            Home
                        </Navbar.Brand>
                    </Navbar> 
                    <Container style={{paddingTop:"25px"}}>
                    <Switch>
                            <Route exact path="/" component={Home} />
                    </Switch>
                    </Container>
                </Router>
            </div>
        )
    }
}

ReactDOM.render(
       <App />,
     document.querySelector("#root")
);
