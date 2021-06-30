import "./App.css";
import React from "react";
import "semantic-ui-css/semantic.min.css";
import Navi from "./components/Navi";
import JobAdvertDetail from "./components/JobAdvertDetail";
import { Container } from "semantic-ui-react";
// import { Footer } from "./components/Footer";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import SignUp from "./components/SignUp";
import SignIn from "./components/SignIn";
import JobAdvertList from "./components/JobAdvertList";
import CreateCv from "./components/CreateCv";

function App() {
    return (
        <div
            className="App"
            style={{
                minHeight: "50rem",
            }}
        >
            <Router>
                <Container
                    className="content-container"
                    style={{ minHeight: "100vh" }}
                >
                    <Navi />
                    <Switch>
                        <Route exact path="/" component={JobAdvertList} />
                        <Route
                            exact
                            path="/findJob"
                            component={JobAdvertList}
                        />
                        <Route
                            exact
                            path="/jobAdvertDetail/:id"
                            component={JobAdvertDetail}
                        />
                        <Route exact path="/signup" component={SignUp} />
                        <Route path="/signin" exact component={SignIn} />
                        <Route path="/createcv" exact component={CreateCv} />
                    </Switch>
                </Container>
            </Router>
            {/* <div className="footer">
                <Footer />
            </div> */}
        </div>
    );
}

export default App;
