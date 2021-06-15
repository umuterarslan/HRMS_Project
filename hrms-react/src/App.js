import "./App.css";
import React, { useState } from "react";
import "semantic-ui-css/semantic.min.css";
import Navi from "./components/Navi";
import { FindJob } from "./components/FindJob";
import JobAdvertDetail from "./components/JobAdvertDetail";
import { Container } from "semantic-ui-react";
import { Footer } from "./components/Footer";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import SignUp from "./components/SignUp";
import SignIn from "./components/SignIn";
import CreateCv from "./components/CreateCv";

function App() {
    const [pageName, setPageName] = useState("/");

    return (
        <Router>
            <div
                className="App"
                style={{
                    minHeight: "50rem",
                }}
            >
                <Navi className="nav-bar" />
                <Container className="content-container">
                    <Switch>
                        <Route exact path="/" component={FindJob} />
                        <Route exact path="/findJob" component={FindJob} />
                        <Route
                            path="/jobAdvertDetail/:id"
                            component={JobAdvertDetail}
                        />
                        <Route path="/signup" component={SignUp} />
                        <Route path="/signin" component={SignIn} />
                        <Route path="/createcv" component={CreateCv} />
                    </Switch>
                </Container>
                {/* <div className="footer">
                <Footer />
            </div> */}
            </div>
        </Router>
    );
}

export default App;
