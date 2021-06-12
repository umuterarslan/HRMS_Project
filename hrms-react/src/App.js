import "./App.css";
import React from "react";
import "semantic-ui-css/semantic.min.css";
import Navi from "./components/Navi";
import { FindJob } from "./components/FindJob";
import JobAdvertDetail from "./components/JobAdvertDetail";
import { Container } from "semantic-ui-react";
import { Footer } from "./components/Footer";
import { BrowserRouter as Router, Route } from "react-router-dom";

function App() {
    return (
        <div
            className="App"
            style={{
                minHeight: "50rem",
            }}
        >
            <Navi />
            <Container className="find-job-container">
                <Router>
                    <Route exact path="/" component={FindJob} />
                    <Route exact path="/findJob" component={FindJob} />
                    <Route
                        path="/jobAdvertDetail/:id"
                        component={JobAdvertDetail}
                    />
                </Router>
            </Container>
            {/* <div className="footer">
                <Footer />
            </div> */}
        </div>
    );
}

export default App;
