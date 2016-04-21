<div class="modal analyses_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="analyses-update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update analyse info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="analyses_edit_id" name="analyse.id" type="hidden">
                        <div class="form-group">
                            <label>Doctor:
                                <select required class="form-control" name="analyse.doctorId">
                                    <s:iterator value="doctorsList" var="doctor">
                                        <option value="<s:property value="id"></s:property>">
                                            <s:property value="getFullname()"></s:property>
                                        </option>
                                    </s:iterator>
                                </select>
                            </label>
                        </div>
                        <div class="form-group">
                            <label>Client:
                                <select required class="form-control" name="analyse.clientId">
                                    <s:iterator value="clientsList" var="client">
                                        <option value="<s:property value="id"></s:property>">
                                            <s:property value="getFullname()"></s:property>
                                        </option>
                                    </s:iterator>
                                </select>
                            </label>
                        </div>
                        <div class="form-group">
                            <label>Visit id:
                                <select required class="form-control" name="analyse.visitId">
                                    <s:iterator value="visitsList" var="visit">
                                        <option value="<s:property value="id"></s:property>">
                                            <s:property value="id"></s:property>
                                        </option>
                                    </s:iterator>
                                </select>
                            </label>
                        </div>
                        <div class="form-group">
                            <label>Name: <input type="text" required class="form-control" name="analyse.name"></label>
                        </div>
                        <div class="form-group">
                            <label>Result: <input type="text" required class="form-control" name="analyse.result"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save changes</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

