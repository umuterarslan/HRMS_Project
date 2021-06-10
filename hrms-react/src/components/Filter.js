import React from "react";
import { Dropdown, Icon, Input, Menu } from "semantic-ui-react";

export const Filter = () => {
    return (
        <div className="find-job-filter">
            <Menu vertical>
                <Menu.Item>
                    <Input placeholder="Search..." />
                </Menu.Item>
                <Menu.Item>
                    Will Filter
                    <Menu.Menu>
                        <Menu.Item
                            name="search"
                            // active={activeItem === "search"}
                            // onClick={this.handleItemClick}
                        >
                            Empty
                        </Menu.Item>
                        <Menu.Item
                            name="add"
                            // active={activeItem === "add"}
                            // onClick={this.handleItemClick}
                        >
                            Empty
                        </Menu.Item>
                        <Menu.Item
                            name="about"
                            // active={activeItem === "about"}
                            // onClick={this.handleItemClick}
                        >
                            Empty
                        </Menu.Item>
                    </Menu.Menu>
                </Menu.Item>
                <Menu.Item
                    name="browse"
                    // active={activeItem === "browse"}
                    // onClick={this.handleItemClick}
                >
                    <Icon name="grid layout" />
                    Empty
                </Menu.Item>
                <Menu.Item
                    name="messages"
                    // active={activeItem === "messages"}
                    // onClick={this.handleItemClick}
                >
                    Empty
                </Menu.Item>
                <Dropdown item text="Empty">
                    <Dropdown.Menu>
                        <Dropdown.Item icon="edit" text="Empty" />
                        <Dropdown.Item icon="globe" text="Empty" />
                        <Dropdown.Item icon="settings" text="Empty" />
                    </Dropdown.Menu>
                </Dropdown>
            </Menu>
        </div>
    );
};
