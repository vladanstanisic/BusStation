import React from "react";
import ReactDOM from "react-dom";
import {Route, Link, HashRouter as Router, Switch } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import  {Container, Navbar, Nav, Button} from "react-bootstrap";
import Home from './components/Home';
import {logout} from './services/auth';
import Login from './components/login/Login';


class App extends React.Component{
    render() {
        return (
            <div>
                <Router>
                    <Navbar expand bg="dark" variant="dark">
                        <Navbar.Brand as={Link} to="/">
                            Home
                        </Navbar.Brand>
                        <Nav>

                            {window.localStorage['jwt'] ? 
                            <Button onClick = {()=>logout()}>Logout</Button> :
                            <Nav.Link as={Link} to="/login">Log in</Nav.Link>
                            }
                        </Nav>
                    </Navbar> 
                    <Container style={{paddingTop:"25px"}}>
                    <Switch>
                            <Route exact path="/" component={Home} />
                            <Route exact path="/login" component={Login}/>
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
