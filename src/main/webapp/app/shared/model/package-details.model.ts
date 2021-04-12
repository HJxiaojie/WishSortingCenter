import { Moment } from 'moment';

export interface IPackageDetails {
  id?: number;
  trackingId?: string;
  groupId?: string;
  jobId?: string;
  isFinish?: boolean;
  finishTime?: Moment;
  userCode?: string;
  xNum?: number;
  yNum?: number;
  xy?: string;
}

export class PackageDetails implements IPackageDetails {
  constructor(
    public id?: number,
    public trackingId?: string,
    public groupId?: string,
    public jobId?: string,
    public isFinish?: boolean,
    public finishTime?: Moment,
    public userCode?: string,
    public xNum?: number,
    public yNum?: number,
    public xy?: string
  ) {
    this.isFinish = this.isFinish || false;
  }
}
