import React, { useState, useEffect } from "react";
import JobAdvertService from "../services/jobAdvertService";
import TrialFuck from "./TrialFuck";

export default function Trial() {
    const jobAdvertService = new JobAdvertService();
    const [jobAdverts, setJobAdverts] = useState([]);
    const [queryFilter, setQueryFilter] = useState("");

    useEffect(() => {
        jobAdvertService
            .getJobAdverts()
            .then((success) => setJobAdverts(success.data.data));
    }, []);

    function search(jobAdverts) {
        return jobAdverts.filter(
            (jobAdvert) =>
                jobAdvert.employer.companyName
                    .toLowerCase()
                    .indexOf(queryFilter) > -1 ||
                jobAdvert.description.toLowerCase().indexOf(queryFilter) > -1
        );
    }

    return (
        <div>
            <div>
                <input
                    type="text"
                    value={queryFilter}
                    onChange={(e) => setQueryFilter(e.target.value)}
                />
            </div>
            <div>
                <TrialFuck jobAdverts={search(jobAdverts)} />
            </div>
        </div>
    );
}
