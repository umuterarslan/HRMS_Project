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
import CvCreate from "./components/CvCreate";
import CvEdit from "./components/CvEdit";
import CvDetail from "./components/CvDetail";
import JobAdvertCreate from "./components/JobAdvertCreate";
import SystemPersonelCreate from "./components/SystemPersonelCreate";
import SystemPersonelUpdate from "./components/SystemPersonelUpdate";
import EmployerDetail from "./components/EmployerDetail";
import EmployerUpdateRequestCreate from "./components/EmployerUpdateRequestCreate";
import EmployerUpdateRequestList from "./components/EmployerUpdateRequestList";

function App() {
    return (
        <div
            className="App"
            style={{
                minHeight: "50rem",
            }}
        >
            <h1>sa</h1>
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
                        <Route path="/cvcreate" exact component={CvCreate} />
                        <Route path="/cvedit" exact component={CvEdit} />
                        <Route path="/cvdetail" exact component={CvDetail} />
                        <Route
                            path="/jobadvertcreate"
                            exact
                            component={JobAdvertCreate}
                        />
                        <Route
                            path="/systempersonelcreate"
                            exact
                            component={SystemPersonelCreate}
                        />
                        <Route
                            path="/systempersonelupdate"
                            exact
                            component={SystemPersonelUpdate}
                        />
                        <Route
                            path="/employerdetail"
                            exact
                            component={EmployerDetail}
                        />
                        <Route
                            path="/employerupdaterequestcreate"
                            exact
                            component={EmployerUpdateRequestCreate}
                        />
                        <Route
                            path="/employerupdaterequestlist"
                            exact
                            component={EmployerUpdateRequestList}
                        />
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
