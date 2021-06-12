import React from "react";
import { Grid } from "semantic-ui-react";
import JobAdvertList from "./JobAdvertList";

import { Filter } from "./Filter";

export const FindJob = () => {
    return (
        <div>
            <Grid>
                <Grid.Row>
                    <Grid.Column width={4}>
                        <Filter />
                    </Grid.Column>
                    <Grid.Column width={12}>
                        <JobAdvertList />
                    </Grid.Column>
                </Grid.Row>
            </Grid>
        </div>
    );
};
