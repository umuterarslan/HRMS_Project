import React, { Component } from "react";
import { Button, Container, Menu } from "semantic-ui-react";

export default function Navi() {
    return (
        <div>
            <Container>
                <Menu className="nav-bar" inverted fixed="top" size="huge">
                    <Menu.Item name="home" />
                    <Menu.Item name="messages" />
                    <Menu.Item name="friends" />
                    <Menu.Menu position="right">
                        <Menu.Item name="logout" />
                    </Menu.Menu>
                </Menu>
            </Container>
        </div>
    );
}
