import React from "react";
import { Container, Menu, Button } from "semantic-ui-react";

export default function Navi() {
    return (
        <div>
            <Menu size="huge" fixed="top">
                <Container>
                    <Menu.Item
                        name="home"
                        // active={activeItem === "home"}
                        // onClick={this.handleItemClick}
                    />
                    <Menu.Item
                        name="İş İlanları"
                        // active={activeItem === "messages"}
                        // onClick={this.handleItemClick}
                    />
                    <Menu.Item position="right">
                        <Button primary>Sign Up</Button>
                    </Menu.Item>
                </Container>
            </Menu>
        </div>
    );
}
