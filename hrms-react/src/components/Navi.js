import React, { useState, initialState } from "react";
import { Container, Menu, Button } from "semantic-ui-react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { Link } from "react-router-dom";

export default function Navi() {
    return (
        <div>
            <Menu
                size="huge"
                fixed="top"
                style={{
                    boxShadow: "0 2px 0 0 rgba(0, 0, 0, 0.2)",
                }}
            >
                <Container>
                    <Router>
                        <Menu.Item>
                            <Link to="/findJob">İş Bul</Link>
                        </Menu.Item>
                        <Menu.Item>
                            <Link to="/findJob">İş Bul</Link>
                        </Menu.Item>
                        <Menu.Item position="right">
                            <Link to="/signin">Üyelik</Link>
                        </Menu.Item>
                    </Router>
                </Container>
            </Menu>
        </div>
    );
}
