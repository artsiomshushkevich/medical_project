<div class="modal schedules_add_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="schedules-add.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Add new schedule</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <div class="form-group">
                            <label>Doctor id: <input type="number" class="form-control" name="schedule.doctorId"></label>
                        </div>
                        <div class="form-group">
                            <label>Workday: <input type="text" class="form-control" name="schedule.workday"></label>
                        </div>
                        <div class="form-group">
                            <label>Begin workday: <input type="text" class="form-control" name="schedule.beginWorkday"></label>
                        </div>
                        <div class="form-group">
                            <label>End workday: <input type="text" class="form-control" name="schedule.endWorkday"></label>
                        </div>
                        <div class="form-group">
                            <label>Room: <input type="number" class="form-control" name="schedule.room"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->