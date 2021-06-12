import "./App.css";
import React from "react";
import "semantic-ui-css/semantic.min.css";
import Navi from "./components/Navi";
import { FindJob } from "./components/FindJob";
import JobAdvertDetail from "./components/JobAdvertDetail";
import { Container } from "semantic-ui-react";
import { Footer } from "./components/Footer";
import { BrowserRouter as Router, Route } from "react-router-dom";
import SignUp from "./components/SignUp";

function App() {
    return (
        <div
            className="App"
            style={{
                minHeight: "50rem",
            }}
        >
            <Navi className="nav-bar" />
            <Container className="find-job-container">
                <Router>
                    <Route exact path="/" component={FindJob} />
                    <Route exact path="/findJob" component={FindJob} />
                    <Route
                        path="/jobAdvertDetail/:id"
                        component={JobAdvertDetail}
                    />
                    <Route exact path="/signup" component={SignUp} />
                </Router>
            </Container>
            {/* <div className="footer">
                <Footer />
            </div> */}
        </div>
    );
}

export default App;
