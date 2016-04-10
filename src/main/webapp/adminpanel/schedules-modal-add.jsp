<div class="modal schedules_add_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="schedules-add.action" enctype="multipart/form-data">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Add new schedule</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <div class="form-group">
                            <label>Doctor id: <input type="number" min="1" required class="form-control" name="schedule.doctorId"></label>
                        </div>
                        <div class="form-group">
                            <label>Workday: <input type="text" required class="form-control" name="schedule.workday"></label>
                        </div>
                        <div class="form-group">
                            <label>Begin workday: <input type="time" required class="form-control" name="beginWorkTime"></label>
                        </div>
                        <div class="form-group">
                            <label>End workday: <input type="time" required class="form-control" name="endWorkTime"></label>
                        </div>
                        <div class="form-group">
                            <label>Room: <input type="number" required min="0" class="form-control" name="schedule.room"></label>
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